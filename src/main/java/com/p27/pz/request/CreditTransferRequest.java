package com.p27.pz.request;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditTransferRequest {

    @NotNull
    private String mgsId;

    @Override
    public String toString() {
        return "CreditTransferRequest{" +
                "mgsId='" + mgsId + '\'' +
                '}';
    }
}
