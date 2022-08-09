package com.p27.pz.response;

import com.p27.pz.configuration.TransactionStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditTransferResponse {

    private String mgsId;

    private TransactionStatus status;

    public CreditTransferResponse(String mgsId) {
        this.mgsId = mgsId;
        if(mgsId.hashCode() % 2 == 0) {
            this.status = TransactionStatus.ACCP;
        }
        else {
            this.status = TransactionStatus.RJCT;
        }
    }

    @Override
    public String toString() {
        return "Mgs id: " + getMgsId() +
                "\nStatus: " + this.status.name() + "\n";
    }
}
