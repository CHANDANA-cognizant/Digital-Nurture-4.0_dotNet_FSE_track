import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euros: ''
    };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const euroValue = (this.state.rupees / 90).toFixed(2);
    this.setState({ euros: euroValue });
  };

  render() {
    return (
      <div style={{ marginTop: '30px' }}>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>Enter Amount in Rupees: </label>
          <input type="number" value={this.state.rupees} onChange={this.handleChange} />
          <button type="submit">Convert</button>
        </form>
        {this.state.euros && (
          <p>Equivalent in Euros: €{this.state.euros}</p>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
