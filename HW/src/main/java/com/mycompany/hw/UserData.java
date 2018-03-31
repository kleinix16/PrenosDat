
package com.mycompany.hw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserData {

    @SerializedName("data")
    @Expose
    public UserWithAvatar data;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).toString();
    }

}
