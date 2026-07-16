import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

const flightlist = [
    {
        flightNumber: "AA-2405",
        airline: "American Airlines",
        origin: "LAX",
        destination: "JFK",
    },
    {
        flightNumber: "DL-0892",
        airline: "Delta Air Lines",
        origin: "ATL",
        destination: "ORD",
    },
    {
        flightNumber: "LH-0430",
        airline: "Lufthansa",
        origin: "FRA",
        destination: "ORD",
    },
    {
        flightNumber: "EK-0202",
        airline: "Emirates",
        origin: "DXB",
        destination: "LHR",
    },
    {
        flightNumber: "SQ-0022",
        airline: "Singapore Airlines",
        origin: "SIN",
        destination: "EWR",
    }
];

function ShowFlightDetails({isLoggedIn}) {
    return (
        flightlist.map((flight) => {
            return (
                <div class="list-group">
                    <a class="list-group-item list-group-item-action">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">{flight.airline}</h5>
                            <small class="text-body-secondary">{flight.flightNumber}</small>
                        </div>
                        <p class="mb-1">{flight.origin}</p>
                        <p class="mb-1">{flight.destination}</p>
                        {/* Evaluates the Condition (&&) */}
                        {isLoggedIn && (   
                            <button className="btn btn-success mt-2">Book</button>
                        )}
                    </a>
                </div>
            );
        })
    );
}

export default ShowFlightDetails;