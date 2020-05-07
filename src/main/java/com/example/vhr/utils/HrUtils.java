package com.example.vhr.utils;

import com.example.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Auther:zhugq
 * @Date: 2020/04/29/11:10
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
