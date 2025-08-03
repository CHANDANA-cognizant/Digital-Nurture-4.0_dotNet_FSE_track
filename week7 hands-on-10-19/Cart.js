import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <div style={{ border: '1px solid black', padding: '10px', margin: '5px' }}>
        <h3>Item: {this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

// Optional: Define default props
Cart.defaultProps = {
  itemname: "Default Item",
  price: 0
};

export default Cart;
