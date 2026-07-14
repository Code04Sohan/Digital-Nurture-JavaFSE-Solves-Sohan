import React from "react";
import './App.css'
import Cart from "./Cart";

class OnlineShopping extends React.Component {
  render(){
    const shoppingCart = [
      {name:"TV", price: 100},
      {name:"TV", price: 100},
      {name:"TV", price: 100},
      {name:"TV", price: 100},
      {name:"TV", price: 100}
    ]
    return(
      <div className="mydiv">
        <h1 className="mydiv h1">Order Sum</h1>
        <Cart product = {shoppingCart}/>
      </div>
    );
  }
}

export default OnlineShopping;