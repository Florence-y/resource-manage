package com.florence.resources.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.florence.resources.common.reply.ResponseStat;
import com.florence.resources.common.reply.ResponseStatHelper;
import com.florence.resources.dto.Page;
import com.florence.resources.dto.ReimbursementDto;
import com.florence.resources.po.Reimbursement;
import com.florence.resources.service.IReimbursementService;
import com.florence.resources.utils.SessionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 报销 前端控制器
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {
    @Autowired
    IReimbursementService reimbursementService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    ResponseStat<Reimbursement> save(@RequestBody Reimbursement reimbursement, HttpServletRequest request) {
        reimbursement.setEventStartTime(LocalDateTime.now());
        reimbursement.setUserId((Long) SessionUtil.getSessionAttribute(request, "userId"));
        boolean save = reimbursementService.save(reimbursement);
        return save ? ResponseStatHelper.success("申请成功") : ResponseStatHelper.error("申请失败");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    ResponseStat<Reimbursement> update(@RequestBody Reimbursement reimbursement, HttpServletRequest request) {
        boolean save = reimbursementService.updateById(reimbursement);
        return save ? ResponseStatHelper.success("操作成功") : ResponseStatHelper.error("操作失败");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    Page<ReimbursementDto> list(Page<Reimbursement> page, HttpServletRequest request, @RequestParam(value = "status",required = false) Integer status) {
        if (!Objects.isNull(status)){
            QueryWrapper<Reimbursement> condition = new QueryWrapper<>();
            condition.eq("status",status);
            reimbursementService.page(page,condition);
        }else {
            reimbursementService.page(page);
        }

        Page<ReimbursementDto> pageDto = new Page<>();
        BeanUtils.copyProperties(page, pageDto);
        List<ReimbursementDto> reimbursementDtos = new ArrayList<>();
        page.getRecords().forEach((reimbursement) -> {
            ReimbursementDto reimbursementDto = poConvert(reimbursement);
            reimbursementDto.setUserNumber((String) SessionUtil.getSessionAttribute(request, "number"));
            reimbursementDtos.add(reimbursementDto);
        });
        pageDto.setRecords(reimbursementDtos);
        return pageDto;
    }

    private ReimbursementDto poConvert(Reimbursement reimbursement) {
        ReimbursementDto reimbursementDto = new ReimbursementDto();
        BeanUtils.copyProperties(reimbursement, reimbursementDto);
        return reimbursementDto;
    }



}
