package com.sdlg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdlg.pojo.TSetmeal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sdlg
 * @since 2024-12-26
 */
public interface TSetmealMapper extends BaseMapper<TSetmeal> {
    @Delete("delete from oorder where order_status = '未支付'")
    void deleteOuttimeOrders();

    @Update("UPDATE oorder SET order_status = '已完成' WHERE order_date = CurDate();")
    void updateOrders();

    @Update("UPDATE ordersetting SET reservations = (select count(reservations) from oorder where order_date = CurDate() ) WHERE order_date = CurDate();")
    void updateOrdersetting();
}
