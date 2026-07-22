import { Component } from "react";

class Cart extends Component {
  render() {
    return (
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Price (₹)</th>
          </tr>
        </thead>

        <tbody>
          {this.props.items.map((item, index) => (
            <tr key={index}>
              <td>{item.itemname}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

export default Cart;