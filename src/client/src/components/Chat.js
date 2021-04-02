import { useEffect, useState } from 'react';
import { Button, TextField, Icon } from "@material-ui/core";
import { AiOutlineSend } from "react-icons/all";

const Message = ({content, user, time}) => {
  return <div className={'message'}>
    <div className={'user'}>{user}</div>
    <div className={'content'}>{content}<div className={'time'}>{time}</div>
    </div>
  </div>;
};

const Chat = ({user}) => {
  const [log, setLog] = useState([]);
  const [text, setText] = useState('');

  const handleChange = e => {
    setText(e.target.value);
  }

  const handleSubmit = e => {
    e.preventDefault();
    const message = {content: text, time: (new Date()).toLocaleTimeString('it-IT'), user: user.name};
    setLog([...log, message]);
    setText('');
  }

  return (
    <div className='Chat'>
      <div className='log'>
        {log.map(o => <Message user={o.user} content={o.content} time={o.time}/>)}
      </div>
      <form className='input' onSubmit={handleSubmit} autoComplete='off'>
        <TextField value={text} onChange={handleChange} id="outlined-search" label="Type your message" variant="outlined"/>
        <Button onClick={handleSubmit} variant="outlined"><AiOutlineSend/></Button>
      </form>
    </div>
  );
};

export default Chat;
