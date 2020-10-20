package com.video.system.mapper;


import com.video.system.domain.SysShoppingCart;

import java.util.List;


/**
 * <p>
 * (购物车) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysShoppingCartMapper {

    List<SysShoppingCart> selectShoppingCartList(Long userId);

    int addCartInfo(SysShoppingCart shoppingCart);


    int deleteCartInfo(SysShoppingCart shoppingCart);

}
