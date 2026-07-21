import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);

    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState(
      prevState => ({
        count: prevState.count + 1
      }),
      () => {
        this.sayHello();
      }
    );
  };

  decrement = () => {
    this.setState(prevState => ({
      count: prevState.count - 1
    }));
  };

  sayHello = () => {
    alert('Hello! Member');
  };

  sayWelcome = message => {
    alert(message);
  };

  handleSyntheticEvent = () => {
    alert('I was clicked');
  };

  render() {
    return (
      <div className="section">
        <h2>Counter Example</h2>

        <h3>Counter Value: {this.state.count}</h3>

        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome('Welcome')}>Say Welcome</button>
        <button onClick={this.handleSyntheticEvent}>Click on me</button>
      </div>
    );
  }
}

export default Counter;
