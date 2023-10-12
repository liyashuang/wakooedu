package com.ruoyi.educationalAdministration.mapper;

import java.util.List;
import com.ruoyi.educationalAdministration.domain.Attachment;

/**
 * 附件管理Mapper接口
 * 
 * @author wakoo
 * @date 2023-10-10
 */
public interface AttachmentMapper 
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
     * 删除附件管理
     * 
     * @param id 附件管理主键
     * @return 结果
     */
    public int deleteAttachmentById(Long id);

    /**
     * 批量删除附件管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAttachmentByIds(String[] ids);
}
