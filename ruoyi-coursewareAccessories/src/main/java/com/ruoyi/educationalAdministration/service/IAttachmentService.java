package com.ruoyi.educationalAdministration.service;

import java.util.List;
import com.ruoyi.educationalAdministration.domain.Attachment;

/**
 * 附件管理Service接口
 * 
 * @author wakoo
 * @date 2023-10-10
 */
public interface IAttachmentService 
{
    /**
     * 查询附件管理
     * 
     * @param id 附件管理主键
     * @return 附件管理
     */
    public Attachment selectAttachmentById(Long id);

    /**
     * 查询附件管理列表
     * 
     * @param attachment 附件管理
     * @return 附件管理集合
     */
    public List<Attachment> selectAttachmentList(Attachment attachment);

    /**
     * 新增附件管理
     * 
     * @param attachment 附件管理
     * @return 结果
     */
    public int insertAttachment(Attachment attachment);

    /**
     * 修改附件管理
     * 
     * @param attachment 附件管理
     * @return 结果
     */
    public int updateAttachment(Attachment attachment);

    /**
     * 批量删除附件管理
     * 
     * @param ids 需要删除的附件管理主键集合
     * @return 结果
     */
    public int deleteAttachmentByIds(String ids);

    /**
     * 删除附件管理信息
     * 
     * @param id 附件管理主键
     * @return 结果
     */
    public int deleteAttachmentById(Long id);
}
