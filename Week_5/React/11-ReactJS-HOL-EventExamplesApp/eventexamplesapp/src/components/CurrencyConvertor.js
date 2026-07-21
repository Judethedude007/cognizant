import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);

    this.state = {
      rupees: '',
      euros: ''
    };
  }

  handleChange = event => {
    this.setState({
      rupees: event.target.value
    });
  };

  convertCurrency = event => {
    event.preventDefault();

    const euroValue = Number(this.state.rupees) / 90;

    this.setState({
      euros: euroValue.toFixed(2)
    });
  };

  render() {
    return (
      <div className="section">
        <h2>Currency Convertor</h2>

        <form onSubmit={this.convertCurrency}>
          <label>Amount in Rupees: </label>
          <input
            type="number"
            value={this.state.rupees}
            onChange={this.handleChange}
            placeholder="Enter rupees"
          />

          <button type="submit">Convert</button>
        </form>

        {this.state.euros && (
          <h3>Amount in Euro: {this.state.euros}</h3>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
