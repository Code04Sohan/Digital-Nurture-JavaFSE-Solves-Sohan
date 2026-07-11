import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import trainerMock from './TrainersMock';
import TrainerList from './TrainerList';
import ShowHome from './Home';

function App() {
  return (
    <BrowserRouter>
      <nav>
        <h1>My Academy Trainer App</h1>
        <Link to="/home">
          Home
        </Link>

        <Link to="/trainers">
          Show Trainer List
        </Link>
      </nav>
      <main>
        <Routes>
          <Route path="/home" element={<ShowHome />} />
          <Route path="/trainers" element={<TrainerList trainers={trainerMock} />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
