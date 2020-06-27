package my.struts.domain.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 */
@Data
public class MUser implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6003303781921187152L;

    private Integer id;

    private String userId;

    private String userName;

}