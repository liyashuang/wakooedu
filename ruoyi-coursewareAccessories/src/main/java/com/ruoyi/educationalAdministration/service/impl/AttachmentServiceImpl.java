package com.ruoyi.educationalAdministration.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.educationalAdministration.mapper.AttachmentMapper;
import com.ruoyi.educationalAdministration.domain.Attachment;
import com.ruoyi.educationalAdministration.service.IAttachmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 附件管理Service业务层处理
 * 
 * @author wakoo
 * @date 2023-10-10
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService 
{
    @Autowired
    private AttachmentMapper attachmentMapper;

    /**
     * 查询附件管理
     * 
     * @param id 附件管理主键
     * @return 附件管理
     */
    @Override
    public Attachment selectAttachmentById(Long id)
    {
        return attachmentMapper.selectAttachmentById(id);
    }

    /**
     * 查询附件管理列表
     * 
     * @param attachment 附件管理
     * @return 附件管理
     */
    @Override
    public List<Attachment> selectAttachmentList(Attachment attachment)
    {
        return attachmentMapper.selectAttachmentList(attachment);
    }

    /**
     * 新增附件管理
     * 
     * @param attachment 附件管理
     * @return 结果
     */
    @Override
    public int insertAttachment(Attachment attachment)
    {
        attachment.setCreateTime(DateUtils.getNowDate());
        return attachmentMapper.insertAttachment(attachment);
    }

    /**
     * 修改附件管理
     * 
     * @param attachment 附件管理
     * @return 结果
     */
    @Override
    public int updateAttachment(Attachment attachment)
    {
        attachment.setUpdateTime(DateUtils.getNowDate());
        return attachmentMapper.updateAttachment(attachment);
    }

    /**
     * 批量删除附件管理
     * 
     * @param ids 需要删除的附件管理主键
     * @return 结果
     */
    @Override
    public int deleteAttachmentByIds(String ids)
    {
        return attachmentMapper.deleteAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件管理信息
     * 
     * @param id 附件管理主键
     * @return 结果
     */
    @Override
    public int deleteAttachmentById(Long id)
    {
        return attachmentMapper.deleteAttachmentById(id);
    }
}
