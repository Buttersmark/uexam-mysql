package com.alvis.exam.viewmodel;

import com.alvis.exam.base.BasePage;
import com.alvis.exam.utility.ModelMapperSingle;
import lombok.Data;
import org.modelmapper.ModelMapper;

/**
 * @author 高xh
 */

@Data
public class BaseVM {
    protected static ModelMapper modelMapper = ModelMapperSingle.Instance();


}
