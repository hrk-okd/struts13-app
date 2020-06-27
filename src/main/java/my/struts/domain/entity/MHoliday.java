package my.struts.domain.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 */
@Data
public class MHoliday implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6003303781921187152L;

    private Integer id;

    private Integer year;

    private Integer month;

    private Integer day;
}