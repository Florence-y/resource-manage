package com.florence.resources.controller;


import com.florence.resources.common.reply.ResponseStat;
import com.florence.resources.common.reply.ResponseStatHelper;
import com.florence.resources.po.Reimbursement;
import com.florence.resources.service.IReimbursementService;
import com.florence.resources.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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
    ResponseStat<Reimbursement> save(@RequestBody Reimbursement reimbursement, HttpServletRequest request){
        reimbursement.setEventStartTime(LocalDateTime.now());
        reimbursement.setUserId((Long) SessionUtil.getSessionAttribute(request,"userId"));
        boolean save = reimbursementService.save(reimbursement);
        return  save? ResponseStatHelper.success("申请成功"):ResponseStatHelper.error("申请失败");
    }
}
