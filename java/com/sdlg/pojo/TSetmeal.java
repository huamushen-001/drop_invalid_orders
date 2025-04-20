package com.sdlg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sdlg
 * @since 2024-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TSetmeal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String code;

    private String helpCode;

    private String sex;

    private String age;

    private Float price;

    private String remark;

    private String attention;

    private String img;


}
