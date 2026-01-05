import DefaultRoundedButton from "./presentation/components/DefaultRoundedButon";
import { StyleSheet, Text, View, Image, TextInput } from "react-native";

export default function App() {
  return (
    <View style={styles.container}>
      <Image
        style={styles.imageBackground}
        source={require("./assets/city.jpg")}
      />

      <View style={styles.form}>
        <Image style={styles.imageUser} source={require("./assets/user.png")} />
        <Text style={styles.textLogin}>LOGIN</Text>

        <View style={styles.containerTextInput}>
          <Image
            style={styles.textInputIcon}
            source={require("./assets/email.png")}
          ></Image>
          <TextInput
            style={styles.textInput}
            placeholder="Correo Electronico"
            placeholderTextColor="white"
          />
        </View>

        <View style={styles.containerTextInput}>
          <Image
            style={styles.textInputIcon}
            source={require("./assets/password.png")}
          ></Image>
          <TextInput
            style={styles.textInput}
            placeholder="Contraseña"
            placeholderTextColor="white"
          />
        </View>

        <DefaultRoundedButton
          text="INICIAR SESION"
          onPress={() => {
            // Handle login press
          }}
          backgroundColor="blue"
        />

        <View style={styles.containerTextDontHaveAccount}>
          <View style={styles.divider}></View>
          <Text style={styles.textDontHaveAccount}>No Tienes Cuenta?</Text>
          <View style={styles.divider}></View>
        </View>

        <DefaultRoundedButton
          text="REGISTRATE"
          onPress={() => {
            // Handle register press
          }}
          backgroundColor="green"
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "black",
    alignItems: "center",
    justifyContent: "center",
  },
  imageBackground: {
    width: "100%",
    height: "100%",
    opacity: 0.7,
  },
  form: {
    width: "87%",
    height: "75%",
    position: "absolute",
    backgroundColor: "rgba(255,255,255,0.2)",
    borderRadius: 40,
    justifyContent: "center",
    paddingHorizontal: 25,
  },
  imageUser: {
    width: 150,
    height: 150,
    alignSelf: "center",
    marginBottom: 15,
  },
  textLogin: {
    color: "white",
    fontSize: 20,
    fontWeight: "bold",
    alignSelf: "center",
  },
  textInput: {
    width: "90%",
    height: 50,
    borderBottomWidth: 1,
    borderBottomColor: "white",
    color: "white",
    fontSize: 18,
  },
  textDontHaveAccount: {
    color: "white",
    fontSize: 14,
  },
  containerTextInput: {
    flexDirection: "row",
    alignItems: "center",
    marginTop: 10,
  },
  textInputIcon: {
    width: 25,
    height: 25,
    marginRight: 15,
  },
  containerTextDontHaveAccount: {
    flexDirection: "row",
    alignSelf: "center",
    alignItems: "center",
    marginTop: 15,
  },
  divider: {
    height: 1,
    width: 75,
    backgroundColor: "white",
    marginHorizontal: 5,
  },
});
