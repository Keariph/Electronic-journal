import React from "react";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import {GetStudent} from "../Web";

export default function Header({
  /**
   * ф-ия, которая вызовется по клику на иконку меню
   */
  onMenuClick,
}) {
  const [student, setStudent] = React.useState({});

  React.useEffect(() => {
    GetStudent().then((result) => {
      setStudent(result.student[0]);
    })
  }, []);

  return (
    <AppBar position="sticky">
      <Toolbar>
        <IconButton
          color="inherit"
          aria-label="open drawer"
          onClick={onMenuClick}
          edge="start"
        >
          <MenuIcon />
        </IconButton>
        <Typography variant="h6" noWrap>
          {student.name}
        </Typography>
      </Toolbar>
    </AppBar>
  );
}
