package my.struts.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import my.struts.domain.entity.MHoliday;

/**
 * 
 */
@Mapper
public interface HolidayMapper {

    /**
     * 休暇テーブルを検索します。
     * 
     * @return 休暇情報
     */
    @Select("select * from public.m_holiday")
    List<MHoliday> findAll();

}