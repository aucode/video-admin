package com.video.system.service.impl;

import com.video.common.utils.StringUtils;
import com.video.system.domain.SysShoppingCart;
import com.video.system.mapper.SysShoppingCartMapper;
import com.video.system.service.SysShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (购物车) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysShoppingCartServiceImpl implements SysShoppingCartService {

    @Autowired
    private SysShoppingCartMapper shoppingCartMapper;

    @Override
    public List<SysShoppingCart> selectShoppingCartList(Long cartId) {
        return shoppingCartMapper.selectShoppingCartList(cartId);
    }

    @Override
    public int addCartInfo(SysShoppingCart shoppingCart) {
        return shoppingCartMapper.addCartInfo(shoppingCart);
    }

    @Override
    public int deleteCartInfo(SysShoppingCart shoppingCart) {
        return shoppingCartMapper.deleteCartInfo(shoppingCart);
    }
}
