import React from "react";
import Drawer from "@material-ui/core/Drawer";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import useStyles from "./styles";

export default function Navigation({
  /**
   * open = false - панель навигации закрыта,
   * open = true - панель навигации открыта,
   */
  open,
  /**
   * onClose - функция, которая вызовется при закрытии панели навигации, пожалуйста, проставьте в ней open = false
   */
  onClose,
}) {
  const classes = useStyles();
  const items = ["География", "Математика", "Русский Язык"];
  return (
    <Drawer
      anchor="left"
      open={open}
      onClose={() => onClose && onClose()}
      onOpen={() => {}}
    >
      <div className={classes.navigation}>
        <List>
          {items.map((item, index) => (
            <ListItem button key={index}>
              {item}
            </ListItem>
          ))}
        </List>
      </div>
    </Drawer>
  );
}
