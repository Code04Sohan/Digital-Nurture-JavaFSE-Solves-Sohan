import logo from './logo.svg';
import './App.css';
import Header from './Header';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div className="App">
      <div className='App-header'v>
        <Header />
      </div>
      <div className='App-header'>
        <CurrencyConvertor />
      </div>
    </div>
  );
}

export default App;
