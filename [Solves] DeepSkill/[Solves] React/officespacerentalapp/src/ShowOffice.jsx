import React from "react";

const element = "Office Space";
const sr = "https://img.magnific.com/free-photo/modern-office-space-interior_158595-5206.jpg?semt=ais_hybrid&w=740&q=80";
const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;

export default function ShowOffice({ offices }) {
    return (
        <div>
            {offices.map((item) => {
                const rentIndicator = item.Rent <= 60000 ? 'red' : 'green';
                return (
                    <div>
                        <h1>{element} ,At affordable Price</h1>
                        {jsxatt}
                        <h2>Name : {item.Name}</h2>
                        <h3 style={{ color: rentIndicator }}>Rent : {item.Rent}</h3>
                        <h3>Address {item.Address}</h3>
                    </div>
                );
            })}
        </div>
    );
}