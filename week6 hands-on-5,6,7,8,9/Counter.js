import React from 'react';

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };

    // bind methods
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
  }

  increment() {
    this.setState(prev => ({ count: prev.count + 1 }));
    this.sayHello();
  }

  decrement = () => {
    this.setState(prev => ({ count: prev.count - 1 }));
  };

  sayHello() {
    alert("Hello! This is a static message.");
  }

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleSyntheticEvent = (e) => {
    e.preventDefault(); // using synthetic event
    alert("I was clicked");
  };

  render() {
    return (
      <div>
        <h2>Counter Value: {this.state.count}</h2>
        <button onClick={this.increment}>Increase</button>
        <button onClick={this.decrement}>Decrease</button>

        <br /><br />
        <button onClick={() => this.sayWelcome("Welcome to the event handler!")}>
          Say Welcome
        </button>

        <br /><br />
        <button onClick={this.handleSyntheticEvent}>Synthetic Event Button</button>
      </div>
    );
  }
}

export default Counter;
