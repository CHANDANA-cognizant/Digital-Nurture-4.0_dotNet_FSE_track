import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  constructor(props) {
    super(props);

    this.cartItems = [
      { itemname: "Laptop", price: 75000 },
      { itemname: "Smartphone", price: 25000 },
      { itemname: "Headphones", price: 3000 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Mouse", price: 800 }
    ];
  }

  render() {
    return (
      <div>
        <h2>Welcome to Online Shopping</h2>
        {this.cartItems.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
