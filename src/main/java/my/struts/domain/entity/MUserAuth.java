package my.struts.domain.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 */
@Data
public class MUserAuth implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6003303781921187152L;

    private String userId;

    private String password;

}