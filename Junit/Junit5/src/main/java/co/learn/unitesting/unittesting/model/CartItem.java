package co.learn.unitesting.unittesting.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Log
public class CartItem {

    private Integer itemId;
    private String itemName;
    private double rate;
    private Integer quantity;
    private boolean isExpired;
}
