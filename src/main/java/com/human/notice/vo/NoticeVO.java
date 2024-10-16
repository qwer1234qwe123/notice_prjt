package com.human.notice.vo;

import java.util.Date;

import lombok.Data;
@Data
public class NoticeVO {
    private int n_idx;
    private String n_category;
    private String n_title;
    private String n_content;
    private Date n_regdate;
    private Date n_update;
    private String n_status;

}
