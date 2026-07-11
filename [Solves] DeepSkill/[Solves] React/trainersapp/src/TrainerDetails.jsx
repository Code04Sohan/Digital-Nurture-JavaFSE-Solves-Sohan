import React from 'react';
import { useParams, Link } from 'react-router-dom';
import trainerMock from './TrainersMock';

function TrainerDetail() {
  const { id } = useParams();

  const trainer = trainerMock.find((t) => t.trainerId == id);

  return (
    <div>
      <h2>Trainer Details</h2>
      <p>Trainer ID : {trainer.trainerId}</p>
      <p>Trainer Name : {trainer.name}</p>
      <p>Trainer Email : {trainer.email}</p>
      <p>Trainer Phone : {trainer.phone}</p>
      <p>Trainer Tech : {trainer.technology}</p>
      <p>Skills :
        <ul>
          {trainer.skills.map((skill, index) => (
            <li key={index}>{skill}</li>
          ))}
        </ul>
      </p>
    </div>
  );
}
export default TrainerDetail;