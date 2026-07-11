import React from "react";
import { Link } from "react-router-dom";

function TrainerList({ trainers }) {
    return (
        <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
            <h2>Trainer List</h2>
            <ul>
                {trainers.map((trainer) => (
                    <li key={trainer.trainerId}>
                        <Link to={`/trainers/${trainer.trainerId}`}>
                            {trainer.name}
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TrainerList;

// ==== Note ====
// <ul> is Unordered List & <li> isList Item 
// <Link> is (React Router Link) This is a custom React component that creates a clickable hyperlink.