package com.godcoder.myhome.validator;

import org.thymeleaf.util.StringUtils;
import com.godcoder.myhome.model.Board;
import net.bytebuddy.implementation.bind.annotation.Empty;
import net.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }


    @Override
    public void validate(Object obj, Errors errors) {
        Board b = (Board) obj;
        if(StringUtils.isEmpty(b.getContent())) {
            errors.rejectValue("content", "key", "내용을 입력하세요.");
        }
    }
}
