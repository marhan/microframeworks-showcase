/*
 *    Copyright 2015 Benjamin Schmid, @bentolor
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package model;

import lombok.Data;

/** A item to buy on a grocery list. */
@Data
public class Item implements ModelElement {

    private int quantity;
    private Unit unit;
    private String name;

    public Item() {
    }

    public Item(int quantity, Unit unit, String name) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

}