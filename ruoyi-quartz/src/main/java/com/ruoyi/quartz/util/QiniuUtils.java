package com.ruoyi.quartz.util;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**七牛工具类
 *
 * @author HASEE
 */
public class QiniuUtils {

    public static String uploadAvatar(MultipartFile file, String accessKey, String secretKey, String bucketName, String folderPath) throws IOException {
            try {
                // 创建七牛云配置对象
                Configuration cfg = new Configuration();
                // 创建七牛云授权对象
                Auth auth = Auth.create(accessKey, secretKey);
                // 创建七牛云上传管理器对象
                UploadManager uploadManager = new UploadManager(cfg);

                // 获取上传文件的原始文件名作为七牛云的文件名
                String key = file.getOriginalFilename();
                // 指定上传文件目录，如果未指定则默认为空字符串，即上传到根目录

                if (!folderPath.isEmpty()) {
                    // 在文件名前拼接指定文件夹路径和斜杠，形成完整的文件路径
                    key = folderPath + "/" + key;
                }

                // 获取上传文件的字节数组
                byte[] fileBytes = file.getBytes();

                // 生成上传凭证
                String upToken = auth.uploadToken(bucketName);
                // 调用上传方法进行文件上传
                Response response = uploadManager.put(fileBytes, key, upToken);

                // 处理上传响应结果
                if (response.isOK()) {
                    // 文件上传成功，拼接文件的URL
                    return "https://cdn.wakoohome.com/" + key;
                } else {
                    return "上传失败";
                }
            } catch (Exception ex) {
                return "上传失败";
            }
    }
}