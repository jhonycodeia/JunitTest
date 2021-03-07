package co.learn.unitesting.unittesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Log
public class Cart {

    private Integer cardId;
    private List<CartItem> cartItemList;

}
