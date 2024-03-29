package com.atakandalkiran.bbnb.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Random;

import kotlinx.parcelize.Parcelize;

@Entity(
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "userId",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE
        )
)
@Parcelize
public class CardDetailsModel implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int cardId;

    public int userId;

    @ColumnInfo(name = "title")
    private String cardTitle;

    @ColumnInfo(name = "card_no")
    private String cardNo;

    @ColumnInfo(name = "usable_limit")
    private Integer usableLimit;

    @ColumnInfo(name = "balance")
    private Integer balance;

    @ColumnInfo(name = "debt")
    private Integer debt;


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getUsableLimit() {
        if( usableLimit == null) {
            return generateRandomParameter(5000, 100000);
        }
        return usableLimit;
    }

    public void setUsableLimit(Integer usableLimit) {
        this.usableLimit = usableLimit;
    }

    public Integer getBalance() {
        if (balance == null) {
            return generateRandomParameter(5000, usableLimit);
        }
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getDebt() {
        if (debt == null) {
            return generateRandomParameter(0, 10000);
        }
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }


    private static int generateRandomParameter(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public CardDetailsModel() {
        // Your constructor logic here...
    }
    protected CardDetailsModel(Parcel in) {
        cardId = in.readInt();
        userId = in.readInt();
        cardTitle = in.readString();
        if (in.readByte() == 0) {
            cardNo = null;
        } else {
            cardNo = in.readString(); // Use readInt() for Integer
        }
        if (in.readByte() == 0) {
            usableLimit = null;
        } else {
            usableLimit = in.readInt();
        }
        if (in.readByte() == 0) {
            balance = null;
        } else {
            balance = in.readInt();
        }
        if (in.readByte() == 0) {
            debt = null;
        } else {
            debt = in.readInt();
        }
    }

    public static final Creator<CardDetailsModel> CREATOR = new Creator<CardDetailsModel>() {
        @Override
        public CardDetailsModel createFromParcel(Parcel in) {
            return new CardDetailsModel(in);
        }

        @Override
        public CardDetailsModel[] newArray(int size) {
            return new CardDetailsModel[size];
        }
    };

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(cardId);
        dest.writeInt(userId);
        dest.writeString(cardTitle);
        if (cardNo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeString(cardNo); // Use writeInt() for Integer
        }
        if (usableLimit == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(usableLimit);
        }
        if (balance == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(balance);
        }
        if (debt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(debt);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
