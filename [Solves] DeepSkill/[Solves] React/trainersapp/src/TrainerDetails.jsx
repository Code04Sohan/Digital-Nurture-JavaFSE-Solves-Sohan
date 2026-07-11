import React from 'react';
import { useParams, Link } from 'react-router-dom';
import trainerMock from './TrainersMock';

function TrainerDetail() {
  // 1. Retrieve the parameter named 'id' from the URL
  const { id } = useParams();

  // 2. Query the mock data array using the extracted id
  const trainer = trainersMock.find((t) => t.trainerId === id);

  // 3. Fallback handle if data does not exist
  if (!trainer) {
    return <h2 style={{ padding: '20px' }}>Trainer Not Found</h2>;
  }

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Trainer Detail</h2>
      <hr />
      <div style={{ marginTop: '15px', lineHeight: '1.6' }}>
        <p><strong>Trainer ID:</strong> {trainer.trainerId}</p>
        <p><strong>Name:</strong> {trainer.name}</p>
        <p><strong>Email:</strong> {trainer.email}</p>
        <p><strong>Phone:</strong> {trainer.phone}</p>
        <p><strong>Technology:</strong> {trainer.technology}</p>
        <div>
          <strong>Skills:</strong>
          <ul style={{ margin: '5px 0', paddingLeft: '20px' }}>
            {trainer.skills.map((skill, index) => (
              <li key={index}>{skill}</li>
            ))}
          </ul>
        </div>
      </div>
      <br />
      <Link to="/trainers" style={{ color: '#0066cc', textDecoration: 'underline' }}>
        Back to List
      </Link>
    </div>
  );
}

export default TrainerDetail;