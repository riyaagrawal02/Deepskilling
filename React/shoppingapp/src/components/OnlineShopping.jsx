import  { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);

    this.items = [
      { itemname: "Laptop", price: 65000 },
      { itemname: "Mouse", price: 700 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Headphones", price: 2500 },
      { itemname: "Monitor", price: 12000 },
    ];
  }

  render() {
    return (
      <div>
        <h1>Online Shopping Cart</h1>

        <Cart items={this.items} />
      </div>
    );
  }
}

export default OnlineShopping;