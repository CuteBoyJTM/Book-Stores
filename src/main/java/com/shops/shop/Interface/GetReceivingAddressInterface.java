package com.shops.shop.Interface;

import com.shops.shop.Bean.ReceivingAddress;

import java.util.List;

public interface GetReceivingAddressInterface {
    List<ReceivingAddress> getReceivingAddress(int user_id,
                                            int start_subscript,
                                            int pageSize);
    List<ReceivingAddress> getReceivingAddressById(int id);
}
