import React from "react";
import Navigation from "../Navigation";
import Header from "../Header";
import TableSelection from '../Tabs';
import useStyles from "./styles";



export default function App() {
  const classes = useStyles();
  const [openNavigation, setOpenNavigation] = React.useState(false);
  return (
    <>
      <Header
        onMenuClick={() => {
          setOpenNavigation(true);
        }}
      />
      <Navigation
        open={openNavigation}
        onClose={() => setOpenNavigation(false)}
      />
      <main className={classes.content}>
        Пиши тут свой код...
        <TableSelection/>
        <div className={classes.root}>
    </div>
        </main>
    </>
  );
}