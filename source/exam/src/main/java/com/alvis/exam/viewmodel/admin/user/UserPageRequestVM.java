package com.alvis.exam.viewmodel.admin.user;

import com.alvis.exam.base.BasePage;
import lombok.Data;

/**
 * @author 高xh
 */

@Data
public class UserPageRequestVM extends BasePage {

    private String userName;
    private Integer role;

}
