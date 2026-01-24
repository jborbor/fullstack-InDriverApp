import { StyleSheet, Text, View, Image, TextInput } from "react-native";
import DefaultTextInput from "../../../components/DefaultTextInput";
import DefaultRoundedButton from "../../../components/DefaultRoundedButon";
import { StackScreenProps } from "@react-navigation/stack";
import { RootStackParamList } from "../../../navigator/MainStackNavigator";

interface Props extends StackScreenProps<RootStackParamList, "LoginScreen"> { };

export default function LoginScreen({ navigation, route }: Props) {
  return (
    <View style={styles.container}>
      <Image
        style={styles.imageBackground}
        source={require("../../../../assets/city.jpg")}
      />

      <View style={styles.form}>
        <Image style={styles.imageUser} source={require("../../../../assets/user.png")} />
        <Text style={styles.textLogin}>LOGIN</Text>

        <DefaultTextInput
          placeholder="Correo Electronico"
          value=""
          onChangeText={text => { }}
          icon={require("../../../../assets/email.png")}
          keyboardType="email-address"
        />

        <DefaultTextInput
          placeholder="Contraseña"
          value=""
          onChangeText={text => { }}
          icon={require("../../../../assets/password.png")}
          secureTextEntry={true}
        />

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
          onPress={() => navigation.navigate("RegisterScreen")}
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
  textDontHaveAccount: {
    color: "white",
    fontSize: 14,
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