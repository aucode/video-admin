package com.video.system.service;

import com.video.system.domain.SysShoppingCart;

import java.util.List;

/**
 * <p>
 * (购物车) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysShoppingCartService {

    List<SysShoppingCart> selectShoppingCartList(Long cartId);

    int addCartInfo(SysShoppingCart shoppingCart);

    int deleteCartInfo(SysShoppingCart shoppingCart);

}
