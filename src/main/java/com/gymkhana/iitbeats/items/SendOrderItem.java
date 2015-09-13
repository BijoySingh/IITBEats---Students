package com.gymkhana.iitbeats.items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class SendOrderItem implements Serializable {

    public List<SendOrderSubItem> items = new ArrayList<>();
    public String comments;

    public SendOrderItem() {
    }
}
