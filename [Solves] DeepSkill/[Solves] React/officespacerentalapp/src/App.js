import logo from './logo.svg';
import './App.css';
import ShowOffice from './ShowOffice';
import offices from './OfficeList';

function App() {
  return (
    <div className="App">
      <ShowOffice offices={offices}/>
    </div>
  );
}

export default App;
