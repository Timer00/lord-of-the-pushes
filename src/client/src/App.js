import logo from './logo.svg';
import './App.scss';
import Chat from "./components/Chat";

let user = {name: 'Cabrón'}

function App() {
  return (
    <div className="container">
      <div className='chat'><Chat user={user}/></div>
      <div className='windows'>
        <div className="map">todo: MAP</div>
        <div className="search">todo: image search</div>
        <div className="dice">todo: DICE</div>
        <div className="char">todo: CHARACTER</div>
      </div>
    </div>
  );
}

export default App;
