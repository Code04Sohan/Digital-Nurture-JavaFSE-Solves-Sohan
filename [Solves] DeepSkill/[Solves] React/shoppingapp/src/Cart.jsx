import React from "react";
import './App.css'
class Cart extends React.Component {
    render() {
        return (
            <table className="cart-table">
                <thead>
                    <tr>
                        <th className="cart-table th">Product</th>
                        <th className="cart-table th">Price</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.product.map((item) => {
                        return (
                            <tr>
                                <td>{item.name}</td>
                                <td>{item.price}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        );
    }
}
export default Cart;