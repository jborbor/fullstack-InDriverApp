package com.project.indriver_backend_sb.models.id;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class UserRoleId implements Serializable {

    @Column(name = "id_user")
    private Long userId;

    @Column(name = "id_rol")
    private Long roleId;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof UserRoleId)) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(userId, roleId);
    }

}
